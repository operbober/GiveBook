/**
 * Created by FruityDevil on 08.03.2016.
 */
'use strict';

app.controller('loginController', ['$scope', 'authService', function ($scope, authService) {


    $scope.credentials = {login: '', password: '', email: ''};

    $scope.authorise = authService.logIn;

    $scope.registerNew = authService.register;
}]);