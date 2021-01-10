
(function() 
{
    var app = angular.module("MyApp", ["ngRoute"]); 
   
    // Colon syntax means it's a parameter and added to $scope.username
    app.config(function($routeProvider) 
    {
        $routeProvider.when("/main", 
        {
            templateUrl: "main.html",
            controller: "MainController"
        }).when("/user/:username", 
        {
            templateUrl: "user.html",
            controller: "UserController"
        }).when("/repo/:username/:reponame", 
        {
            templateURL: "repo.html",
            controller: "RepoController"
        }).otherwise({redirectTo:"/main"});
    });
}());