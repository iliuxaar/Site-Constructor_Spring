var heh = angular.module('page', []);

heh.component('page', {
    templateUrl: '/templates/page.template.html',
    controller: function ($scope,$http,$routeParams,$window) {

        var id = $routeParams.siteId;
        console.log(id);

        $scope.pageinfo = {
            "id":null,
            "name": null,
            "content": null
        }

        $scope.submit = function() {
            console.log($scope.pageinfo);
            $http.post('/site/page/'+ id+ '/save',$scope.pageinfo).success(function() {
                $window.location.href = '#/userpage';
            }).error(function() {
                console.log("Fail");
            });
        };

    }
});