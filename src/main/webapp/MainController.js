
var myApp = angular.module('MyApp');

(function() 
{   
    // MainController is responsible for handling search and countdown functions. 
    var MainController = function ($scope, $interval, $location, $http) 
    {
        // @GET all activities & assign them to the model. 
        var fetchActivities = function() 
        {
            return $http.get("http://localhost:9090/exercise-services/webapi/activities").then(function(activities) 
            {
                $scope.activities = activities.data;
            });
        }
     
        // @POST an activity to the server. 
        $scope.uploadActivity = function() 
        {
            return $http.post("http://localhost:9090/exercise-services/webapi/activities/activity", { desc: $scope.activityName, dur: $scope.activityDuration} ).then(function(response) 
            {
                if (response.status == 200) 
                {
                    $scope.recentlyAddedName = $scope.activityName;
                    $scope.recentlyAddedDuration = $scope.activityDuration;
                    fetchActivities();
                };
            });
        }
        
        // Decrement count until 0 -> search for user. 
        var decrementCountdown = function() 
        {
            $scope.countdown -= 1;
            if ($scope.countdown < 1) 
                $scope.search($scope.username)
        }

         
        var countdownInterval = null;
        var startCountdown = function() 
        {
            // $interval will return 0 once it has invoked the supplied method the specified number of times. 
            countdownInterval = $interval(decrementCountdown, 1000, 5);
        }
       
        // Search for the specified user and load the appropriate view. If countdown is still running stop countdown. 
        $scope.search = function(username) 
        {
            if (countdownInterval != null) 
            {
                $interval.cancel(countdownInterval); 
                $scope.countdown = null;
            }

            $location.path("/user/" + username); 
        }
        
        $scope.username = "angular";
        $scope.countdown = 500;
        fetchActivities();
        startCountdown();
    };
    
    myApp.controller('MainController', ["$scope", "$interval", "$location", "$http", MainController]);
}());

