'use strict';

class EventList extends React.Component {

    llamadaAjax() {

        fetch('/SellTicket', {
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
        const { eventList } = this.props;

        // Ensure eventList is an array and has items
        if (Array.isArray(eventList) && eventList.length > 0) {
            return (
                <div>
                    <ul>
                        {eventList.map((element, index) => (
                            <li key={index} style={{ border: '5px solid' }}>
                                {element}
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
