/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 04.03.2016
 */
var offerTypesUri = '/offerTypes/';
var bookTypesUri = '/bookTypes/';
var bookConditionsUri = '/bookConditions/';
var bookLanguagesUri = '/bookLanguages/';

var itemTemplate = {
    book:{}
};

//var uri = '/offers/';

app.controller('offerController', ['$scope', '$http', '$controller', 'offerService', function ($scope, $http, $controller, offerService) {
    $controller('dictionaryController', {$scope: $scope});

    $scope.offerTypes = [];
    $scope.bookTypes = [];
    $scope.bookConditions = [];
    $scope.bookLanguages = [];

    $scope.newAuthor = {};
    $scope.newWork = {authorListDTO: []};

    $scope.addAuthorToWork = function (authorForPut) {
        if ($scope.newWork.authors === undefined){
            $scope.newWork.authors = [];
        }
        $scope.newWork.authors.push(authorForPut);
        $scope.newAuthor = {};
        $scope.authorsQueryResult = [];
    };

    $scope.addWorkToItem = function (workForPut) {
        if ($scope.item.book === undefined){
            $scope.item.book = {};
        }
        if ($scope.item.book.works === undefined){
            $scope.item.book.works = [];
        }
        $scope.item.book.works.push(workForPut);
        $scope.newWork = {authors: []};
        $scope.authorsQueryResult = [];
        $scope.worksQueryResult = [];
    };

    $scope.removeAuthorFromWork = function (authorForRemove) {
        var index = $scope.newWork.authors.indexOf(authorForRemove);
        if(index != -1) {
            $scope.newWork.authors.splice(index, 1);
        }
    };

    $scope.removeWorkFromItem = function (workForRemove) {
        var index = $scope.item.book.works.indexOf(workForRemove);
        if(index != -1) {
            $scope.item.book.works.splice(index, 1);
        }
    };

    $scope.loadAllLists = function () {
        $scope.getOfferTypes();
        $scope.getBookTypes();
        $scope.getBookConditions();
        $scope.getBookLanguages();
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
        itemForPut.user = null;
        var httpRequest = $http.put(serverUrl + $scope.uri, itemForPut).success(function(data, status) {
            itemTemplate.book.works = undefined;
            $scope.cancelModes();
        });
    };

    $scope.convertAuthorToString = function(author) {

        return offerService.convertAuthorToString(author);
    };

    $scope.convertWorkToString = function(work) {

        return offerService.convertWorkToString(work);
    };

    $scope.convertWorksListToString = function(works) {

        return offerService.convertBookWorksToString(works);
    };

    $scope.worksQueryResult = [];
    $scope.worksLiveSearch = function(title) {

        if (title !== undefined && title.length > 0) {
            var req = {
                method: 'GET',
                url: serverUrl + '/works/search?title=' + title
            };
            $http(req).then(function (response) {
                $scope.worksQueryResult = response.data;
            });
        }
    };

    $scope.authorsQueryResult = [];
    $scope.authorsLiveSearch = function(lastName) {

        if (lastName !== undefined && lastName.length > 0) {
            var req = {
                method: 'GET',
                url: serverUrl + '/authors/search?lastName=' + lastName
            };
            $http(req).then(function (response) {
                $scope.authorsQueryResult = response.data;
            });
        }
    }
}]);