/**
 * Created by admin on 01.03.2016.
 */

'use strict';

var app = angular.module('giveBook', []);

app.controller('IdEntityController', function ($scope, $http) {

    $scope.itemList = [];
    $scope.item = itemTemplate;
    $scope.mode = '';

    $scope.getAll = function() {
        var httpRequest = $http.get(serverUrl + uri).success(function(data, status) {
            $scope.itemList = data;
        });
    };

    $scope.onActionAdd = function() {
        $scope.mode = 'edit';
    };

    $scope.onActionEdit = function(itemForEdit) {
        $scope.item = itemForEdit;
        $scope.mode = 'edit';
    };

    $scope.cancelModes = function() {
        $scope.item = {id: null, name: ''};
        $scope.mode = '';
        $scope.getAll();
    };

    $scope.submitItem = function(itemForPut) {
        var httpRequest = $http.put(serverUrl + uri, itemForPut).success(function(data, status) {
        });
        $scope.cancelModes();
    };

    $scope.deleteItem = function(itemForEdit) {
        var httpRequest = $http.delete(serverUrl + uri + itemForEdit.id, itemForEdit).success(function(data, status) {
            $scope.getAll();
        });
    };
});