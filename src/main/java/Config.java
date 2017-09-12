/* import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Config {
        private static Config instance = null;
        private Properties prop = null;
        FilenameFilter filter = null;
        FilenameFilter dirFilter = null;

        private void loadProperties( String path ) throws Exception {
            File dir = new File(//Config );
            filter = new FilenameFilter() { public boolean accept(/Config, String name) { return name.endsWith(".properties"); } };
            dirFilter = new FilenameFilter() { public boolean accept(/Config, String name) { return dir.isDirectory(); } };
            String files[] = dir.list(filter);

            if( prop == null ){
                prop = new Properties();
            }

            for( String file:files ){
                System.out.println( file );
                File localFile = new File( "config\\" + file );
                if( localFile.isDirectory() ) continue;
                FileInputStream fis = new FileInputStream( localFile.getAbsolutePath() );
                prop.load( fis );
                fis.close();
            }

            String dirs[] = dir.list(dirFilter);
            for( String directory:dirs ){
                loadProperties( path + "\\" + directory );
            }
        }

        private Config() throws Exception {
            loadProperties( "config" );
        }

        public static String getProperty( String propertyName ) throws Exception {
            if( instance == null ){
                instance = new Config();
            }
            return instance.prop.getProperty( propertyName );
        }
}
*/