/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 09.03.2016
 */

app.controller('HeaderController', function ($scope) {

    $scope.isAuthenticated = function() {
        return JSON.parse(sessionStorage.getItem('currentUser')) != '';
    };

    $scope.isAlive = true;
    $scope.getCurrentUser = function() {
        return JSON.parse(sessionStorage.getItem('currentUser'));
    };
});