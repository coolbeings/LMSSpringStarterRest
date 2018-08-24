lmsApp.controller("authorController", function($scope, $http, lmsConstants, adminFactory, Pagination){
	adminFactory.getAll(lmsConstants.HOST_URL+lmsConstants.GET_ALL_AUTHORS).then(function(data){
		$scope.authors = data;
		$scope.pagination = Pagination.getNew(10);
		$scope.pagination.numPages = Math.ceil($scope.authors.length/$scope.pagination.perPage);
	})
	$scope.deleteAuthor = function(authorId){
		var author = { "authorId": authorId};
		$http.post("http://localhost:8080/updateAuthor", author).success(function(data){
			$http.get("http://localhost:8080/readAuthors").success(function(data){
				$scope.authors = data;
			})
		})
	}
	$scope.updateAuthor = function(author){
		$http.post("http://localhost:8080/updateAuthor", author).success(function(data){
			$http.get("http://localhost:8080/readAuthors").success(function(data){
				$scope.authors = data;
			})
		})
	}
	
	$scope.popEditModal = function(a){
		$scope.editAuthor = a; 
	}
	
	$scope.popNewAuthor = function(){
		$http.get("http://localhost:8080/initAuthor").success(function(data){
			$scope.editAuthor = data;
		})
		
		$http.get("http://localhost:8080/readBooks?title=").success(function(data){
			$scope.books = data;
		})
	}
	
	$scope.searchAuthors = function(searchString){
		$http.get("http://localhost:8080/readAuthorsByName/"+searchString).success(function(data){
			$scope.authors = data;
			$scope.pagination = Pagination.getNew(10);
			$scope.pagination.numPages = Math.ceil($scope.authors.length/$scope.pagination.perPage);
		})
	}
})