/**
 * Created by FruityDevil on 11.05.2016.
 */

"use strict";

app.controller('footerController', ['$scope', 'dictionaryService', function ($scope, dictionaryService) {

    var quotesUri = '/quotes/';

    $scope.currentQuote = '';

    $scope.onLoad = function () {
        dictionaryService.getAll(quotesUri).success(function (data) {
            $scope.currentQuote = data[Math.floor(Math.random() * data.length)];
        });
    };

}]);