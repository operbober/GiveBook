/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 09.03.2016
 */

"use strict";

app.controller('headerController', ['$scope', 'securityService', 'authService', function ($scope, securityService, authService) {

    $scope.isAuthenticated = securityService.isAuthenticated;

    $scope.hasRole = securityService.hasRole;

    $scope.getAccessToken = securityService.getAccessToken;

    $scope.onLogOutClick = authService.logOut;

    $scope.onRefreshClick = authService.refresh;
}]);