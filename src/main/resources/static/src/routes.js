lmsApp.config(["$routeProvider", function($routeProvider){
	return $routeProvider.when("/", {
		redirectTo: "/lms/home"
	}).when("/lms/home", {
		templateUrl: "views/welcome.html"
	}).when("/lms/admin", {
		templateUrl: "views/admin/admin.html"
	}).when("/lms/admin/author", {
		templateUrl: "views/admin/author.html"
	}).when("/lms/admin/viewauthors", {
		templateUrl: "views/admin/viewauthors.html"
	})
}])