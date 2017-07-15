/**
 * 
 */
app.directive("homeAboutUs", function() {
    return {
    	 templateUrl : "includes/aboutus.html"
    };
});

app.directive("homeFeature", function() {
    return {
    	 templateUrl : "includes/features.html"
    };
});
app.directive("homeReviews", function() {
    return {
    	 templateUrl : "includes/reviews.html"
    };
});

app.directive("homePriceEstimate", function() {
    return {
    	 templateUrl : "includes/priceestimate.html"
    };
});

app.directive("homeSignIn", function() {
    return {
    	 templateUrl : "views/signin.html"
    };
});
app.directive("homeContactUs", function() {
    return {
    	 templateUrl : "includes/contactus.html"
    };
});