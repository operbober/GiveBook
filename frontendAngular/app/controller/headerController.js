/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 09.03.2016
 */

"use strict";

app.controller('headerController', ['$scope', function ($scope) {

    $scope.isAuthenticated = function() {
        return sessionStorage.getItem('token') !== null
            ? JSON.parse(sessionStorage.getItem('token')) !== ''
            : false;
    };

    $scope.getToken = function() {
        return JSON.parse(sessionStorage.getItem('token'));
    };

    $scope.logOut = function() {
        sessionStorage.removeItem('token');
    };
}]);