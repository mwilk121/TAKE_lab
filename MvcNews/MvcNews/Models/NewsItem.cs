using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace MvcNews.Models
{
    public class NewsItem
    {
        private int id;
        private DateTime timeStamp;
        private string text;
        private byte[] rowVersion;


        public int Id { get => id; set => id = value; }

        [DataType(DataType.Date)]
        public DateTime TimeStamp { get => timeStamp; set => timeStamp = value; }
        
        [Required]
        [StringLength(140,MinimumLength = 5)]
        public string Text { get => text; set => text = value; }
       
        [Timestamp]
        public byte[] RowVersion { get => rowVersion; set => rowVersion = value; }

    }
}
