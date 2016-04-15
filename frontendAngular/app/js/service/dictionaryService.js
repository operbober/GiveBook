/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 21.03.2016
 */
'use strict';

services
    .factory('dictionaryService', ['$http', '$cookies', function($http, $cookies){

        return {
            getAll: function(uri) {
                return $http.get(serverUrl + uri)
                    .success(function(data, status) {
                        return data;
                })
            },

            submitItem: function(uri, itemForPut) {

                $http.defaults.headers.put['Authorization'] = 'Bearer ' + $cookies.get('access_token');
                return $http.put(serverUrl + uri, itemForPut)
                    .success(function(data, status) {
                        return data;
                })
            },

            deleteItem: function(uri, itemForEdit) {

                $http.defaults.headers.put['Authorization'] = 'Bearer ' + $cookies.get('access_token');
                return $http.delete(serverUrl + uri + itemForEdit.id, itemForEdit)
                    .success(function(data, status) {

                        return data;
                })
            }
        };
    }]);