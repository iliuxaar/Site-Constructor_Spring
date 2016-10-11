angular.
    module('app').
    controller("home", function($http, $location, $scope,$translate) {
        $http.get("/user").success(function(data) {
            if (data.name) {
                $scope.user = data.name;
                $scope.authenticated = true;
            } else {
                notAuthenticated()
            }
        }).error(function() {
            notAuthenticated()
        });

        var notAuthenticated = function() {
            $scope.user = "N/A";
            $scope.authenticated = false;
        }

        $scope.logout = function() {
            $http.post('/logout', {}).success(function() {
                $scope.authenticated = false;
                $location.path("/");
            }).error(function(data) {
                console.log("Logout failed");
                $scope.authenticated = false;
            });
        };

        $scope.changeLanguage = function (langKey) {
            $translate.use(langKey);
        }
    });

