var myApp  =  angular.module('myApp', []);

myApp.controller('jsonCtrl', function($scope, $http){
    $http.get('http://localhost:8080/users').success(function (data){
        $scope.employees = data;
    });

    $scope.addEmp = function(){
        $scope.employees.push({ id:$scope.id, login:$scope.login });
    }
    
    $scope.getTotalEmployees    =   function(){
        return $scope.employees.length;    
    }
        
    $scope.reversedMessage  =   function(){
        return $scope.empName.split("").reverse().join("");
    }
    
});

function testCtrl($scope){
  $scope.names = [
    {name:"Ramesh"},
    {name:"Vinod"},
    {name:"Ateendra"}
    ];
    
   $scope.addName = function(){
      $scope.names.push({ name:$scope.myName });
   }
   
    $scope.reversedMessage  =   function(){
        return $scope.myName.split("").reverse().join("");
    }
    
}

                