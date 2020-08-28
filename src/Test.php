<?php


namespace Dream\Gen;

class Test
{
    public function execute()
    {
        echo 'this is a test. ';
    }


    public function getConfig()
    {
        var_dump(config('test'));
    }
}