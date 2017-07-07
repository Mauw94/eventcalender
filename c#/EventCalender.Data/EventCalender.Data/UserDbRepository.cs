using System.Collections.Generic;
using EventCalender.Data.DomainClasses;

namespace EventCalender.Data
{
    public class UserDbRepository : IUserRepository
    {
        public IEnumerable<User> GetAll()
        {
            throw new System.NotImplementedException();
        }

        public User GetById(int id)
        {
            throw new System.NotImplementedException();
        }

        public User Add(User user)
        {
            throw new System.NotImplementedException();
        }

        public void Update(User user)
        {
            throw new System.NotImplementedException();
        }

        public void Delete(int id)
        {
            throw new System.NotImplementedException();
        }
    }
}