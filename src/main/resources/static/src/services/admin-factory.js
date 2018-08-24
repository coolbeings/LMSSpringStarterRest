lmsApp.factory("adminFactory", function($http){
	return{
		getAll: function(url){
			var returnList = [];
			return $http.get(url).success(function(data){
				returnList = data;
			}).then(function(){
				return returnList;
			})
		},
		getAllWithQuery: function(url, params){
			var returnList = [];
			return $http.get(url+params).success(function(data){
				returnList = data;
			}).then(function(){
				return returnList;
			})
		}
	}
})