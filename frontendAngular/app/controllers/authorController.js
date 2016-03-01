/**
 * Created by admin on 01.03.2016.
 */

'use strict';

var app = angular.module('giveBook', []);

function AuthorController($scope, $http) {

    $scope.authors = [];
    $scope.authorForPut = {id: null, name: ''};

    $scope.getAll = function() {
        var httpRequest = $http.get(serverUrl + '/authors').success(function(data, status) {
            $scope.authors = data.authors;
        });
    };

    $scope.putItem = function() {
        var httpRequest = $http.put(serverUrl + '/authors', $scope.authorForPut).success(function(data, status) {
            //$scope.authors = data;
        });
    };

    $scope.deleteItem = function(authorForDelete) {
        var httpRequest = $http.delete(serverUrl + '/authors/' + authorForDelete.id).success(function(data, status) {
            //$scope.authors = data;
        });
    };
}