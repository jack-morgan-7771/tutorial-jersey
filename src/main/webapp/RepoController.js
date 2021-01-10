
(function()
{    
    var module = angular.module("MyApp");
    
    var RepoController = function($scope, $routeParams, github) 
    {       
        var onRepo = function(data) 
        {
            $scope.repo = data;
        };
        
        var onError = function(reason) 
        {
            $scope.error = reason; 
        };
        
        var reponame = $routeParams.reponame;
        var username = $routeParams.username;
        
        github.getRepoDetails(username, reponame).then(function(data) {});
    };
    
    module.controller("RepoController", ["$scope", "$routeParams", "github", RepoController]);
}());