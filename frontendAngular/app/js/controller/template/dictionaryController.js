/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 04.03.2016
 */
'use strict';

var itemTemplate = {};

app.controller('dictionaryController', ['$scope', '$route', 'dictionaryService',  function($scope, $route, dictionaryService){

    $scope.mode = false;

    var uri = $route.current.$$route.uri;

    $scope.onActionAdd = function() {
        $scope.loadAllLists();
        $scope.item = itemTemplate;
        $scope.mode = true;
    };

    $scope.onActionEdit = function(itemForEdit) {
        $scope.loadAllLists();
        $scope.item = itemForEdit;
        $scope.mode = true;
    };

    $scope.loadAllLists = function(){

    };

    $scope.cancelModes = function() {
        $scope.mode = false;
        loadItems();
    };

    var loadItems = function() {
        dictionaryService.getAll(uri).success(function (data) {
            $scope.itemList = data;
        });
    };

    $scope.onLoad = loadItems;

    $scope.onActionSubmit = function(itemForPut) {
        dictionaryService.submitItem(uri, itemForPut).success(function (data) {
             $scope.mode = false;
             loadItems();
        });
    };

    $scope.onActionDelete = function(itemForDelete) {
        dictionaryService.deleteItem(uri, itemForDelete).success(function (data) {
            loadItems();
        });
    };
}]);