/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 04.03.2016
 */
var uri = '/offers/';
var offerTypesUri = '/offerTypes/';
var bookTypesUri = '/bookTypes/';
var bookConditionsUri = '/bookConditions/';
var usersUri = '/users/';
var itemTemplate = {
    id: null,
    bookName: '',
    bookType: {id: null, name: ''},
    //bookCondition: {id: null, name: ''},
    //offerType: {id: null, name: ''},
    userId: null
};

app.controller('OfferController', function ($scope, $http, $controller) {
    $controller('IdEntityController', {$scope: $scope});

    $scope.offerTypes = [];
    $scope.bookTypes = [];
    $scope.bookConditions = [];
    $scope.users = [];

    $scope.onActionEdit = function(itemForEdit) {
        $scope.item.id = itemForEdit.id;
        $scope.item.bookName = itemForEdit.book.work.name;
        alert(itemForEdit.book.work.titles);
        $scope.item.bookType = itemForEdit.book.bookType;
        $scope.item.userId = itemForEdit.user.id;
        $scope.mode = 'edit';
        $scope.loadAllLists();
    };

    $scope.loadAllLists = function () {
        $scope.getOfferTypes();
        $scope.getBookTypes();
        $scope.getBookConditions();
        $scope.getUsers();
    };

    $scope.getOfferTypes = function () {
        var httpRequest = $http.get(serverUrl + offerTypesUri).success(function (data, status) {
            $scope.offerTypes = data;
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

    $scope.submitItem = function(itemForPut) {
        var httpRequest = $http.put(serverUrl + uri + 'new', itemForPut).success(function(data, status) {
        });
        $scope.cancelModes();
    };

    $scope.getUsers = function () {
        var httpRequest = $http.get(serverUrl + usersUri).success(function (data, status) {
            $scope.users = data;
        });
    };
});