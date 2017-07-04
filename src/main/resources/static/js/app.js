var app = angular.module('app',[]);

app.controller('AuthorCRUDCtrl', ['$scope','AuthorCRUDService', function ($scope,AuthorCRUDService) {
	  
    $scope.updateAuthor = function () {
    	AuthorCRUDService.updateAuthor($scope.author.id,$scope.author.name,$scope.author.email)
          .then(function success(response){
              $scope.message = 'Author data updated!';
              $scope.errorMessage = '';
          },
          function error(response){
              $scope.errorMessage = 'Error updating author!';
              $scope.message = '';
          });
    }
    
    $scope.getAuthor = function () {
        var id = $scope.author.id;
        AuthorCRUDService.getAuthor($scope.author.id)
          .then(function success(response){
              $scope.author = response.data;
              $scope.author.id = id;
              $scope.message='';
              $scope.errorMessage = '';
          },
          function error (response ){
              $scope.message = '';
              if (response.status === 404){
                  $scope.errorMessage = 'Author not found!';
              }
              else {
                  $scope.errorMessage = "Error getting Author!";
              }
          });
    }
    
    $scope.addAuthor = function () {
        if ($scope.author != null && $scope.author.name) {
        	AuthorCRUDService.addUser($scope.author.name, $scope.author.email)
              .then (function success(response){
                  $scope.message = 'Author added!';
                  $scope.errorMessage = '';
              },
              function error(response){
                  $scope.errorMessage = 'Error adding author!';
                  $scope.message = '';
            });
        }
        else {
            $scope.errorMessage = 'Please enter a name!';
            $scope.message = '';
        }
    }
    
    $scope.deleteAuthor = function () {
    	AuthorCRUDService.deleteAuthor($scope.author.id)
          .then (function success(response){
              $scope.message = 'Author deleted!';
              $scope.author = null;
              $scope.errorMessage='';
          },
          function error(response){
              $scope.errorMessage = 'Error deleting author!';
              $scope.message='';
          })
    }
    
    $scope.getAllAuthors = function () {
    	AuthorCRUDService.getAllAuthors()
          .then(function success(response){
              $scope.authors = response.data._embedded.authors;
              $scope.message='';
              $scope.errorMessage = '';
          },
          function error (response ){
              $scope.message='';
              $scope.errorMessage = 'Error getting authors!';
          });
    }

}]);

app.service('AuthorCRUDService',['$http', function ($http) {
	
    this.getAuthor = function getAuthor(authorId){
        return $http({
          method: 'GET',
          url: 'authors/'+authorId
        });
	}
	
    this.addAuthor = function Author(name, email){
        return $http({
          method: 'POST',
          url: 'authors',
          data: {name:name, email:email}
        });
    }
	
    this.deleteAuthor = function deleteAuthor(id){
        return $http({
          method: 'DELETE',
          url: 'authors/'+id
        })
    }
	
    this.updateAuthor = function updateAuthor(id,name,email){
        return $http({
          method: 'PATCH',
          url: 'authors/'+id,
          data: {name:name, email:email}
        })
    }
	
    this.getAllAuthors = function getAllAuthors(){
        return $http({
          method: 'GET',
          url: 'authors'
        });
    }

}]);