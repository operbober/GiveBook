/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 04.03.2016
 */
var uri = '/offers/';
var offerTypesUri = '/offerTypes/';
var booksUri = '/books/';
var usersUri = '/users/';
var itemTemplate = {
};

app.controller('OfferController', function ($scope, $http, $controller) {
    $controller('IdEntityController', {$scope: $scope});

    $scope.offerTypes = [];
    $scope.books = [];
    $scope.users = [];

    //$scope.onActionEdit = function(itemForEdit) {
    //    $scope.item.id = itemForEdit.id;
    //    $scope.item.bookName = itemForEdit.book.work.name;
    //    $scope.item.bookType = itemForEdit.book.bookType;
    //    $scope.item.userId = itemForEdit.user.id;
    //    $scope.mode = 'edit';
    //    $scope.loadAllLists();
    //};

    $scope.loadAllLists = function () {
        $scope.getOfferTypes();
        $scope.getBooks();
        $scope.getUsers();
    };

    $scope.getOfferTypes = function () {
        var httpRequest = $http.get(serverUrl + offerTypesUri).success(function (data, status) {
            $scope.offerTypes = data;
        });
    };

    $scope.getBooks = function () {
        var httpRequest = $http.get(serverUrl + booksUri).success(function (data, status) {
            $scope.books = data;
        });
    };

    $scope.submitItem = function(itemForPut) {
        var httpRequest = $http.put(serverUrl + uri, itemForPut).success(function(data, status) {
        });
        $scope.cancelModes();
    };

    $scope.getUsers = function () {
        var httpRequest = $http.get(serverUrl + usersUri).success(function (data, status) {
            $scope.users = data;
        });
    };
});