<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * Created by PhpStorm.
 * User: Maurits
 * Date: 25-6-2017
 * Time: 14:00
 */
class EventModel extends CI_Model
{
    public function __construct()
    {
        parent::__construct();
    }

    public function getAllEvents()
    {
        $this->db->select('*');
        $this->db->from('event_table');
        $query = $this->db->get();

        return $query->result();
    }

}