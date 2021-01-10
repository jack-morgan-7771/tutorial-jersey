
(function() 
{
    var myApp = angular.module('MyApp');
    
    var UserController = function ($scope, github, $routeParams) 
    {
        var onRepos = function(data) 
        {
            $scope.repos = data;
        }

        var onError = function(reason) 
        {
            $scope.error = "Could not fetch the data!";
        }; 

        var onUserComplete = function(data) 
        {
            $scope.user = data;
            github.getRepos($scope.user).then(onRepos, onError);
        };

        $scope.username = $routeParams.username;
        $scope.repoSortOrder = "-stargazers_count";
        github.getUser($scope.username).then(onUserComplete, onError);  
    };
    
    myApp.controller('UserController', ["$scope", "github", "$routeParams", UserController]);
}());

