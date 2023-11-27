async function showDetailRoom(roomType) {
    const response = await fetch("getDetailAjax?type="+roomType);
    const data = await response.json();
    
    console.log(data);
    $('#detailModal .modal-title').html('Thông tin chi tiết về phòng '+data.type);
    $('#room-img').attr('src', data.img);
    $('#room-description').text(data.detail);
    $('#room-guest').text('Số người tối đa: '+data.guest);
    $('#room-square').text('Diện tích phòng: '+data.square+'m2');
    $('#room-price').text('Giá thuê một đêm: '+data.price+'vnd');
    $('#detailModal #book-btn').attr("href", "/hotel/detail?type="+roomType);

    $('.modal').modal();
}