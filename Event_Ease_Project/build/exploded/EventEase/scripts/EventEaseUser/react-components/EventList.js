'use strict';

class EventList extends React.Component {

    llamadaAjax() {

        fetch('http://localhost:8080/EventEase/SellTicketService', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: ""
        })
        .then(response => response.json())
        .then(data => {
            alert("Ticket successfully acquired");
            console.log('Ticket:', data);
        })
        .catch(error => {
            console.error('There was an error making the request:', error);
        });
    }

    render() {
        // Ensure eventList is an array and has items
        if (Array.isArray(this.props.eventList) && this.props.eventList.length > 0) {
            return (
                <div>
                    <ul>
                        {this.props.eventList.map((element) => (
                            <li  key={element.eventId} style={{ border: '5px solid' }}>
                                {element.name}
                                <button onClick={this.llamadaAjax()}>Buy</button>
                            </li>
                        ))}
                    </ul>
                </div>
            );
        } else {
            // Return null or some fallback UI if the list is empty or not valid
            return null;
        }
    }
}
