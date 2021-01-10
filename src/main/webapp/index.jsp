        
<!-- Shell view. --> 
<html ng-app="MyApp">
    <head>   
        <script data-require="angular.js@*" data-semver="1.3.0-beta.5" src="https://code.angularjs.org/1.3.0-beta.5/angular.js"></script>  
        <script data-require="angular-route@" data-semver="1.2.14" src="http://code.angularjs.org/1.2.14/angular-route.js"></script>
        <script src="app.js"></script>
        <script src="MainController.js"></script>
        <script src="UserController.js"></script>   
        <script src="RepoController.js"></script> 
        <script src="github.js"></script>
    </head>
    
    <body>
        <h1>Github Viewer</h1> 
        <!-- Views/scenes will be loaded here. --> 
        <div ng-view></div> 
    </body>
</html>