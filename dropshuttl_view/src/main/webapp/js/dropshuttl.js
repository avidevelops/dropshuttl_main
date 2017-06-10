/**
 * dropshuttle.js
 * Root namespace module
 */

/*jslint    browser : true, continue : true,
 devel : true, indent : 2, maxerr : 50,
 newcap : true, nomen : true, plusplus:true,
 regexp : true, sloppy : true, vars : true,
 white : true
 */
/*global $, dropshuttl */

var dropshuttl = (function (){
    var initModule = function($container){
        dropshuttl.shell.initModule($container);
    };
    
    return {initModule:initModule};
}());
