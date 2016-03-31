/**
 * Created by FruityDevil on 08.03.2016.
 */
'use strict';

app.controller('loginController', function ($scope, $http) {

    var uri = '/login/';
    $scope.credentials = {login: '', password: ''};

    $scope.authorise = function() {
        var httpRequest = $http.post(serverUrl + uri, $scope.credentials).success(function(data, status) {
            if (data != '') {
                sessionStorage.setItem('currentUser', JSON.stringify(data));
            } else {
                alert('Auth error!');
            }
        });
    };
});