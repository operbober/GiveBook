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
var bookLanguagesUri = '/bookLanguages/';
var usersUri = '/users/';
var itemTemplate = {
	bookDTO:{}
};

app.controller('OfferController', function ($scope, $http, $controller) {
    $controller('IdEntityController', {$scope: $scope});

    $scope.offerTypes = [];
    $scope.bookTypes = [];
    $scope.bookConditions = [];
    $scope.bookLanguages = [];
    $scope.users = [];

    $scope.newAuthor = {};
    $scope.newWork = {};

    $scope.addAuthorToWork = function (authorForPut) {
		if ($scope.newWork.authorListDTO === undefined){
			$scope.newWork.authorListDTO = new Array;
		}
        $scope.newWork.authorListDTO.push(authorForPut);
        $scope.newAuthor = {};
    };

    $scope.addWorkToItem = function (workForPut) {
		if ($scope.item.bookDTO.workListDTO === undefined){
			$scope.item.bookDTO.workListDTO = new Array;
		}
        $scope.item.bookDTO.workListDTO.push(workForPut);
        $scope.newWork = {};
    };

    $scope.loadAllLists = function () {
        $scope.getOfferTypes();
        $scope.getBookTypes();
        $scope.getBookConditions();
        $scope.getBookLanguages();
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

    $scope.getBookLanguages = function () {
        var httpRequest = $http.get(serverUrl + bookLanguagesUri).success(function (data, status) {
            $scope.bookLanguages = data;
        });
    };

    $scope.submitItem = function(itemForPut) {
        //itemForPut.user = JSON.parse(sessionStorage.getItem('currentUser'));
        var httpRequest = $http.put(serverUrl + uri + 'addOffer', itemForPut).success(function(data, status) {
        });
        $scope.cancelModes();
    };

    $scope.getUsers = function () {
        var httpRequest = $http.get(serverUrl + usersUri).success(function (data, status) {
            $scope.users = data;
        });
    };
});
