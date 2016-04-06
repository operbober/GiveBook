/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 05.04.2016
 */
'use strict';

var convertWorkToString = function(work){
    var result = '';
    if (work !== null && work !== undefined) {
        result += work.name;
        if (work.authors !== undefined) {
            work.authors.forEach(function (authorIterator) {
                result += ', ' + convertAuthorToString(authorIterator)
            });
        }
    }
    return result;
};

var convertAuthorToString = function(author){
    if (author !== null && author !== undefined) {
        return author.lastName
            + (author.firstName !== null ? ' ' : '')
            + getFirstCharOfString(author.firstName)
            + getFirstCharOfString(author.middleName);
    }
    return '';
};

var getFirstCharOfString = function(value){
    if (value !== null && value !== undefined) {
        return value.charAt(0) + '.';
    }
    return '';
};

services
    .factory('offerService', [function(){

        return {

            convertWorkToString: convertWorkToString,

            convertAuthorToString: convertAuthorToString,

            convertBookWorksToString: function(works) {
                if (works === undefined) {
                    return;
                }
                var result = '';
                works.forEach (function (workIterator) {
                    result += convertWorkToString(workIterator) + '; ';
                });
                return result;
            }
        }
    }]);