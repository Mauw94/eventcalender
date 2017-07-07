using System.Web;
using System.Web.Http;
using System.Web.Mvc;
using EventCalender.Data;
using EventCalender.Data.DomainClasses;

namespace EventCalender.Controllers
{
    public class EventController : ApiController
    {
        private IEventRepository _eventRepository;
        
        public EventController(IEventRepository eventRepository)
        {
            this._eventRepository = eventRepository;
        }

        // GET/Events
        public IHttpActionResult GetAll()
        {
            return Ok(_eventRepository.GetAll());
        }

        // GET/Events/5
        public IHttpActionResult GetById(int id)
        {
            var ev = _eventRepository.GetById(id);

            if (ev == null) return NotFound();
            
            return Ok(ev);
        }

        // Post: api/Events
        public IHttpActionResult Post(Event ev)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest();
            }
            var createdEventAtRoute = _eventRepository.Add(ev);
            return CreatedAtRoute("DefaultApi", new { controller = "Events", id = ev.Id}, createdEventAtRoute);
        }
        
        // PUT: api/Events/5
        public IHttpActionResult Put(int id, Event ev)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest();
            }

            if (id != ev.Id)
            {
                return BadRequest();
            }

            if (_eventRepository.GetById(id) == null)
            {
                return NotFound();
            }
            
            _eventRepository.Update(ev);
            return Ok();
        }
        
    }
}