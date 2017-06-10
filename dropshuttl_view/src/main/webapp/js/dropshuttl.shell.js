/**
 * dropshuttle.shell.js
 * shell module for dropshuttl
 */

/*jslint    browser : true, continue : true,
 devel : true, indent : 2, maxerr : 50,
 newcap : true, nomen : true, plusplus:true,
 regexp : true, sloppy : true, vars : true,
 white : true
 */
/*global $, dropshuttl */

dropshuttl.shell = (function(){
	//-----------------begin module scope variables--------------
	var 
		configMap = {
			
			main_html : String()
				+'<div  class="dropshuttl-shell-head">'
				   + '<div class="dropshuttl-shell-head-logo"></div>'
				   + '<div class="dropshuttl-shell-head-navigation"></div>'
				   + '<div class="dropshuttl-shell-head-account"></div>'
				  +'</div>'
				  +'<div class="dropshuttl-shell-main">'
				   + '<div class="dropshuttl-shell-main-content"></div>'
				  +'</div>'
				  +'<div class="dropshuttl-shell-foot"></div>'
				  +'<div class="dropshuttl-shell-chat"></div>'
				  +'<div class="dropshuttl-shell-modal"></div>',			  
				  chat_extend_time : 1000,
				  chat_retract_time : 300,
				  chat_extend_height : 450,
				  chat_retract_height : 25,
				  chat_extend_title : 'Click for assistance',
				  chat_retract_title : 'Close chat',
				  anchor_schema_map : {
						chat : { open : true, closed : true }
				 }
			},
			stateMap = { 
				$container : null,
				anchorMap : {},
				isChatRetracted : true
			},
			jQueryMap = {},
			
			setJqueryMap, toggleChat, onClickChat, initModule,
			copyAnchorMap, changeAnchorPart, onHashChange;
	
	//-----------------end module scope variables--------------
	
	//-----------------begin utility methods-------------------
	
	//Return copy of stored anchor map; minimizes overhead
	copyAnchorMap = function(){
		return $.extend(true,{},stateMap.anchorMap);
	};
	
	//-----------------end utility methods---------------------
	
	//-----------------begin DOM methods-----------------------
	//-----begin DOM method /setJqueryMap/
	setJqueryMap = function(){
		var $container = stateMap.$container;
		jQueryMap = {
				$container : $container,
				$chat : $container.find('.dropshuttl-shell-chat')
		};
		
	};
	//-----end DOM method /setJqueryMap/
	
	//-----begin DOM method /toggleChat/
	// purpose      : extend or retract slider
	// Arguments    :
	//  * do_extend : if true 'extends', if false 'retracts'
	//  * callback  : optional function to execute at end of animation
	// settings     :
	//	* chat_extend_time, chat_retract_time
	//  * chat_extend_height, chat_retract_height
	// Returns      : boolean
	//  * true      : animation completed
	//  * false     : animation not completed
	// State	    : set stateMap.isChatRetracted
	// 	* true      : if chat is close
	//	* false     : if chat is open
	//
	toggleChat = function(do_extend, callback){
		var
			px_chat_ht = jQueryMap.$chat.height(),
			isOpen = px_chat_ht === configMap.chat_extend_height,
			isClose = px_chat_ht === configMap.chat_retract_height,
			isSliding = ! isOpen && ! isClose;
		
		//avoid race condition
		if (isSliding){ return false;}
		
		//begin extend chat
		if (do_extend){
			jQueryMap.$chat.animate(
				{ height : configMap.chat_extend_height},
				configMap.chat_extend_time,
				
				function(){
					jQueryMap.$chat.attr(
						'title', configMap.chat_extend_title
					);
					stateMap.isChatRetracted = false;
					if (callback){callback(jQueryMap.$chat);}
				}
			);
			return true;
		}
		// end extend chat
		
		// begin retract chat
		
		jQueryMap.$chat.animate(
				{ height : configMap.chat_retract_height},
				configMap.chat_retract_time,
				
				function(){
					jQueryMap.$chat.attr(
						'title', configMap.chat_retract_title
					);
					stateMap.isChatRetracted = true;
					if (callback){callback(jQueryMap.$chat);}
				}
		);
		return true;
		//end retract slider
	};
	//------------end dom method /toggleSlier/-------------
	
	//begin DOM Method /changeAnchorPart
	
		changeAnchorPart = function(arg_map){
			var
				anchorMapRevise = copyAnchorMap(),
				bool_return = true,
				key_name, key_name_dep;
				
			//begin merge changes into anchor map
			KEYVAL:
			for (key_name in arg_map) {
				if( arg_map.hasOwnProperty( key_name ) ){
					//skip dependent keys during iteration
					if (key_name.indexOf('_')=== 0 ) {continue KEYVAL;}
					
					//update independent key values
					anchorMapRevise[key_name] = arg_map[key_name];
					
					//update matching dependent key
					key_name_dep = '_' + key_name;
					if(arg_map[key_name_dep]){
						anchorMapRevise[key_name_dep] = arg_map[key_name_dep];
					}
					else{
						delete anchorMapRevise[key_name_dep];
						delete anchorMapRevise['_s' + key_name_dep];
					}
				}
			}
			//end merge changes into anchor map
				
			//begin attempt to update URI, if failed revert
			try{
				$.uriAnchor.setAnchor(anchorMapRevise);
			}catch( error ){
				//replace URI with existing stage
				$.uriAnchor.setAnchor(stateMap.anchorMap,null, true);
				bool_return = false;
			}
			//end attempt to update URI
			return bool_return;
		};
	
	//End DOM Method /changeAnchorPart
	//----------	-------end DOM methods-------------------------
	
	//-----------------begin event handlers-------------------
	//begin Event handler /onHashChange/-------------------
	
	onHashChange = function ( event ){
		var 
			anchorMapPrevious = copyAnchorMap(),
			anchorMapProposed,
			_s_chat_previous, _s_chat_proposed,
			s_chat_proposed;
		
		//attempt to parse anchor
		try{
			anchorMapProposed = $.uriAnchor.makeAnchorMap();
		}catch (error){
			$.uriAnchor.setAnchor(anchorMapPrevious,null,true);
			return false;
		}
		
		stateMap.anchorMap = anchorMapProposed;
		
		//convenience vars
		_s_chat_previous = anchorMapPrevious._s_chat;
		_s_chat_proposed = anchorMapProposed._s_chat;
		
		// begin adjust chat if changed
		if(! anchorMapPrevious || _s_chat_previous !== _s_chat_proposed){
			s_chat_proposed = anchorMapProposed.chat;
			switch(s_chat_proposed){
				case 'open' :
					toggleChat(true);
				break;
				
				case 'close' :
					toggleChat(false);
				break;
				
				default:
					toggleChat(false);
					delete anchorMapProposed.chat;
					$.uriAnchor.setAnchor(anchorMapProposed, null, true);
			}
		}
		//end adjust chat if changed
		return false;
	};	
	//End Event handler /onHashChange/-------------------
	
	//Begin event handler /onCLickChat/
	onClickChat = function(event){
		changeAnchorPart({
			chat: (stateMap.isChatRetracted ? 'open' : 'closed')
		});
		return false;
	};
	//End event handler /onCLickChat/
	//-----------------end event handlers---------------------
	
	//-----------------begin public methods-------------------
	//-----begin public method /initModule/
	initModule = function( $container ){
		//load HTML and map jQuery collection
		stateMap.$container = $container;
		$container.html(configMap.main_html);
		setJqueryMap();
		
		//initialize the chat slider and bind click event 
		stateMap.isChatRetracted = true;
		jQueryMap.$chat
			.attr( 'title', configMap.chat_extend_title )
			.click( onClickChat );
		
		//configure uri anchor to use our schema
		$.uriAnchor.configModule({
			schema_map : configMap.anchor_schema_map
		});
		
		// configure and initialize feature modules
		dropshuttl.chat.configModule({});
		dropshuttl.chat.initModule(jQueryMap.$chat);

		$(window)
			.bind ('hashchange', onHashChange)
			.trigger ('hashchange');
	};
	//-----end public method /initModule/
	
	return { initModule : initModule };
	//-----------------end public methods---------------------
}());
