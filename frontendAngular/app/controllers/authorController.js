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

    $scope.addItem = function() {
        var httpRequest = $http.put(serverUrl + '/authors', $scope.authorForPut).success(function(data, status) {
            if ($scope.authorForPut.id == null) {
                $scope.authors.push($scope.authorForPut);
            }
            $scope.authorForPut = {id: null, name: ''};
        });
    };

    $scope.editItem = function(itemForEdit) {
        $scope.authorForPut = itemForEdit;
    };

    $scope.deleteItem = function(itemForEdit) {
        var httpRequest = $http.delete(serverUrl + '/authors/' + itemForEdit.id).success(function(data, status) {
            $scope.authors.splice(0, 1);
        });
    };
}