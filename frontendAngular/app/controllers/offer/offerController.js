/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 04.03.2016
 */

'use strict';

var uri = '/offers/';
var itemTemplate = {
    id: null,
    user:{id: 1, login:''},
    book:{id: null, name:'',
        bookCondition:{id: null, name:''},
        bookType:{id: null, name:''}},
    offerType:{}};

var app = angular.module('giveBook', []);

app.controller('OfferController', function($scope, $controller) {
    $controller('IdEntityController', {$scope: $scope});

});