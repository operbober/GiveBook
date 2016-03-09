/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 04.03.2016
 */

var uri = '/books/';
var worksUri = '/works/';
var bookTypesUri = '/bookTypes/';
var bookConditionsUri = '/bookConditions/';
var itemTemplate = {id: null, work:{id: null, name: ''}};

app.controller('BookController', function ($scope, $http, $controller) {
    $controller('IdEntityController', {$scope: $scope});

    $scope.works = [];
    $scope.bookTypes = [];
    $scope.bookConditions = [];

    $scope.loadAllLists = function () {
        $scope.getWorks();
        $scope.getBookTypes();
        $scope.getBookConditions();
    };


    $scope.getWorks = function () {
        var httpRequest = $http.get(serverUrl + worksUri).success(function (data, status) {
            $scope.works = data;
        });
    };

    $scope.getBookTypes = function () {
        var httpRequest = $http.get(serverUrl + bookTypesUri).success(function (data, status) {
            $scope.bookTypes = data;
        });
    };

    $scope.getBookConditions = function () {
        var httpRequest = $http.get(serverUrl + bookConditionsUri).success(function (data, status) {
            $scope.bookConditions = data;
        });
    };

});