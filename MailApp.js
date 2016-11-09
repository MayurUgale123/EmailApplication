var app = angular.module('mail',[]);
app.controller('mailCtrl', function($scope,$http) {


//alert("test");

 var email = {

		 fname : null,
		 femail : null,
		 toemail : null,
  subject : null,
  cc	: null,
  bcc : null,
  message : null
};
   $scope.email=email;

$scope.send = function(){
	console.log(email);
	
	
	
	
	$http({
 	 method: 'POST',
	  url: '/send-mail',
	  data: $scope.email
	}).then(function successCallback(response) {
		alert("success")
  }, function errorCallback(response) {
		alert("failure")
  });
	
}
  

});

 



