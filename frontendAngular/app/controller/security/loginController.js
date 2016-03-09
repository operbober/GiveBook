/**
 * Created by FruityDevil on 08.03.2016.
 */
'use strict';

var app = angular.module('giveBook', []);
var uri = '/login/';

app.controller('LoginController', function ($scope, $http) {
    sessionStorage.currentUser = {};
    $scope.credentials = {login: '', password: ''};

    $scope.authorise = function() {
        var httpRequest = $http.post(serverUrl + uri, $scope.credentials).success(function(data, status) {
            sessionStorage.setItem('currentUser', JSON.stringify(data));
        });
    };
});