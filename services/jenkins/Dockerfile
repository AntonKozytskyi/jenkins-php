FROM jenkins:1.651.3

ENV PLATFORM laravel

USER jenkins

COPY custom.groovy /usr/share/jenkins/ref/init.groovy.d/custom.groovy

USER root

RUN apt-get update; \
	apt-get -qq install php5 php5-xsl php5-xdebug git ant

COPY platforms/${PLATFORM}.sh /root/platform.sh
RUN bash -c 'source $HOME/platform.sh'

RUN sed -i 's|disable_functions.*=|;disable_functions=|' /etc/php5/cli/php.ini; \
	echo "xdebug.max_nesting_level = 500" >> /etc/php5/mods-available/xdebug.ini

RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin/ --filename=composer; \

    export COMPOSER_BIN_DIR=/root/.composer/bin; \
    export COMPOSER_HOME=/root/.composer; \

    composer global require "phpunit/phpunit=*" --prefer-source --no-interaction; \
    composer global require "squizlabs/php_codesniffer=*" --prefer-source --no-interaction; \
    composer global require "phploc/phploc=*" --prefer-source --no-interaction; \
    composer global require "pdepend/pdepend=*" --prefer-source --no-interaction; \
    composer global require "phpmd/phpmd=*" --prefer-source --no-interaction; \
    composer global require "sebastian/phpcpd=*" --prefer-source --no-interaction; \
    composer global require "theseer/phpdox=*" --prefer-source --no-interaction; \

	ln -s "$COMPOSER_BIN_DIR/pdepend" /usr/local/bin/; \
	ln -s "$COMPOSER_BIN_DIR/phpcpd" /usr/local/bin/; \
	ln -s "$COMPOSER_BIN_DIR/phpcs" /usr/local/bin/; \
	ln -s "$COMPOSER_BIN_DIR/phpdox" /usr/local/bin/; \
	ln -s "$COMPOSER_BIN_DIR/phploc" /usr/local/bin/; \
	ln -s "$COMPOSER_BIN_DIR/phpmd" /usr/local/bin/; \
	ln -s "$COMPOSER_BIN_DIR/phpunit" /usr/local/bin/

RUN apt-get clean -y

USER jenkins
