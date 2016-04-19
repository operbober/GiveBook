/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 14.04.2016
 */
services
    .factory('securityService', [function () {

        return {
            isAuthenticated: function () {
                return sessionStorage.getItem('access_token') !== null
                    ? sessionStorage.getItem('access_token') !== ''
                    : false;
            },

            getAccessToken: function () {
                return 'Bearer ' + sessionStorage.getItem('access_token');
            },

            getRefreshToken: function () {
                return sessionStorage.getItem('refresh_token');
            },

            // Converts string to array and find role in it.
            // @param role
            // @return true when array contains role.
            hasRole: function (role) {
                var roles = JSON.parse(sessionStorage.getItem('authorities'));
                if (roles !== null && role !== null && role !== undefined) {
                    return roles.indexOf(role) !== -1;
                }
                return false;
            }
        }
    }]);