using System.Collections.Generic;
using EventCalender.Data.DomainClasses;

namespace EventCalender.Data
{
    public class EventDbRepository : IEventRepository
    {
        public IEnumerable<Event> GetAll()
        {
            throw new System.NotImplementedException();
        }

        public Event GetById(int id)
        {
            throw new System.NotImplementedException();
        }

        public User Add(Event ev)
        {
            throw new System.NotImplementedException();
        }

        public void Update(Event ev)
        {
            throw new System.NotImplementedException();
        }

        public void Delete(int id)
        {
            throw new System.NotImplementedException();
        }
    }
}