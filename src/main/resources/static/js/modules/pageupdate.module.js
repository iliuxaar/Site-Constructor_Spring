var heh = angular.module('pageupdate', []);

heh.component('pageupdate', {
    templateUrl: '/templates/page.template.html',
    controller: function ($scope,$http,$routeParams,$window) {
        var id = $routeParams.pageId;
        $http.get('/site/page/'+id).success(function (data) {
            site = data;
            $scope.pageinfo = {
                "id":site.id,
                "name": site.pageName,
                "content": site.content
            };

        });




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
