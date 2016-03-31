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
  //      alert(sessionStorage.getItem('currentUser'));
        return sessionStorage.getItem('currentUser') !== null
            ? JSON.parse(sessionStorage.getItem('currentUser')) !== ''
            : false;
    };

    $scope.getCurrentUser = function() {
        return JSON.parse(sessionStorage.getItem('currentUser'));
    };

    $scope.logOut = function() {
        sessionStorage.removeItem('currentUser');
    };
}]);