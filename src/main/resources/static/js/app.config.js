angular.
    module('app').
    config(
        function ($httpProvider, $routeProvider, $translateProvider) {
            $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

            $translateProvider.useStaticFilesLoader({
                prefix: 'js/./',
                suffix: '.json'
            });


            $translateProvider.preferredLanguage('eng');

            $routeProvider.
                    when('/', {
                          template: '<main></main>'
                    }).
                    when('/userpage', {
                          template: '<user></user>'
                    }).
                    when('/drag', {
                        template: '<drag></drag>'
                    }).
                    when('/create/site/', {
                        template: '<create></create>'
                    }).
                    when('/edit/site/:siteId', {
                        template: '<site></site>'
                    }).
                    when('/add/page/site/:siteId', {
                        template: '<page></page>'
                    }).
                    when('/edit/page/:pageId', {
                        template: '<pageupdate></pageupdate>'
                    }).
                    when('/show/site/:siteId', {
                        template: '<show></show>'
                    }).
                    otherwise('/');
        }
        );

