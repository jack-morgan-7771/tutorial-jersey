
(function() 
{
    var github = function($http) 
    {
        // Returns a specified GitHub user.
        var getUser = function(username) 
        {
            return $http.get("https://api.github.com/users/" + username).then(function(response) 
            {
                return response.data;
            });
        };
        
        // Returns all repositories for a specified user.
        var getRepos = function(user) 
        {
            return $http.get(user.repos_url).then(function(response) 
            {
                return response.data;
            });
        }
        
         
        // Return repo and a list of collaborators for that repository.  
        var getRepoDetails = function(username, reponame) 
        {
            var repo;
            var repoUrl = "https://api.github.com/repos/" + username + "/" + reponame;
            
            return $http.get(repoUrl).then(function(response) 
            {
                repo = response.data;
                return $http.get(repoUrl + "/collaborators");
            }).then(function(response)
            {
                repo.collaborators = response.data;
                return repo; 
            });
            
        };
        
        return {
            getRepos:getRepos,
            getUser:getUser,
            getRepoDetails:getRepoDetails
        };
    };
    
    var module = angular.module("MyApp"); 
    module.factory("github", github);
}());