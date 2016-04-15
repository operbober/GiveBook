/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 14.04.2016
 */
services
    .factory('securityService', ['$cookies', function ($cookies) {

        return {
            isAuthenticated: function () {
                return $cookies.get('access_token') !== undefined
                    ? $cookies.get('access_token') !== ''
                    : false;
            },

            getAccessToken: function () {
                return 'Bearer ' + $cookies.get('access_token');
            },

            getRefreshToken: function () {
                return $cookies.get('refresh_token');
            }
        }
    }]);