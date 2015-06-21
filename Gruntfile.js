module.exports = function(grunt){
    grunt.initConfig({
         watch : {
             scripts: {
                 files: ['src\\main\\webapp\\resources\\htdocs\\dist\\js\\app\\*.js',
                         'src\\main\\webapp\\resources\\htdocs\\dist\\css\\vendor\\*.css'],
                 options: {
                     livereload: 8080,
                 }
             }
         }
       /* uglify: {
         build:{
             src: ['src\\main\\webapp\\resources\\htdocs\\dist\\js\\app\\app.js'],
             dest: ['src\\main\\webapp\\resources\\htdocs\\dist\\js\\app\\app.min.js']

         }
     }*/
    });

    /*grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.registerTask('default',['uglify']);
*/   grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.registerTask('default',[]);
};