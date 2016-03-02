/**
 * Created by admin on 01.03.2016.
 */

'use strict';

var app = angular.module('giveBook', []);

function AuthorController($scope, $http) {

    $scope.authors = [];
    $scope.authorForPut = {id: null, name: ''};
    $scope.mode = '';

    $scope.getAll = function() {
        var httpRequest = $http.get(serverUrl + '/authors').success(function(data, status) {
            $scope.authors = data.authors;
        });
    };

    $scope.onActionAdd = function() {
        $scope.mode = 'edit';
    };

    $scope.onActionEdit = function(itemForEdit) {
        $scope.authorForPut = itemForEdit;
        $scope.mode = 'edit';
    };

    $scope.cancelModes = function() {
        $scope.authorForPut = {id: null, name: ''};
        $scope.mode = '';
        $scope.getAll();
    };

    $scope.submitItem = function() {
        var httpRequest = $http.put(serverUrl + '/authors', $scope.authorForPut).success(function(data, status) {
        });
        $scope.cancelModes();
    };

    $scope.deleteItem = function(itemForEdit) {
        var httpRequest = $http.delete(serverUrl + '/authors/' + itemForEdit.id).success(function(data, status) {
            $scope.getAll();
        });
    };
}