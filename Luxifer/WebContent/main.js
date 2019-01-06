/**
 * author: gendseo
 * time: 2019-01-02
 * update: change to es6
 */

$(document).ready(function () {
  /**
   * 全局配置
   */
  var URL = 'http://localhost:8080/JavaWebBooks/BooksApi/';
  var Bid = $("#Bid");
  var Bname = $("#Bname");
  var Bnumber = $("#Bnumber");
  var BtnSubmit = $("#btn_submit");
  var myModal = $("#myModal");
  var myModalLabel = $("#myModalLabel");
  InitTable();

  $("#btn_add").click(function () {
	Bnumber.css("border-color", "#ccc");
    var Bids = [];
    var getSelectRows = $("#table").bootstrapTable("getData", (books) => { return books });
    $.each(getSelectRows, (i, book) => { Bids.push(book.Bid) });
    if (Bids.length == 0) {
    	Bid.val(1);
    } else {
    	var max = Math.max.apply(null, Bids);
    	Bid.val(max + 1);
    }
    Bname.val('');
    Bnumber.val('');
    myModalLabel.text('添加一本图书');
    BtnSubmit.attr("form", "INSERT");
    myModal.modal('show');
  });

  $("#btn_edit").click(function () {
	Bnumber.css("border-color", "#ccc");
    var getSelectRows = $("#table").bootstrapTable("getSelections", (books) => { return books });
    if (getSelectRows.length != 1) {
      alert("没有选中行或者选了多行");
    } else {
      var book = getSelectRows[0];
      Bid.val(book.Bid);
      Bname.val(book.Bname);
      Bnumber.val(book.Bnumber);
      myModalLabel.text('编辑图书信息');
      BtnSubmit.attr("form", "UPDATE");
      myModal.modal('show');
    }
  });

  BtnSubmit.click(function () {
    var btn_status = BtnSubmit.attr("form");
    var reg = new RegExp("^[0-9]*$");
    if (!reg.test(Bnumber.val()) || Bnumber.val() > 9999) {
      alert("图书数量必须为0——9999的整数");
      Bnumber.css("border-color", "#FF0000");
      Bnumber.val('');
      Bnumber.focus();
    } else if (Bname.val() === '' || Bname.val().length === 0) {
      alert("还没有输入书名");
    } else if (Bnumber.val() === '' || Bnumber.val().length === 0) {
      alert("还没有输入图书数量");
    } else {
      if (btn_status === "UPDATE") {
        myModal.modal('hide');
        var UPDATE_JSON = {
          "Bid": parseInt(Bid.val()),
          "Bname": Bname.val().toString(),
          "Bnumber": parseInt(Bnumber.val()),
        }
        $.ajax({
          url: URL + 'UPDATE',
          type: "POST",
          dataType: "text",
          data: JSON.stringify(UPDATE_JSON),
          success: (result) => {
            if (result === "true") {
              $("#table").bootstrapTable("refresh", {});
            } else {
              alert("更新操作未成功");
            }
          },
        });
      }
      if (btn_status === "INSERT") {
        myModal.modal('hide');
        var INSERT_JSON = {
          "Bid": parseInt(Bid.val()),
          "Bname": Bname.val().toString(),
          "Bnumber": parseInt(Bnumber.val()),
        }
        $.ajax({
          url: URL + 'INSERT',
          type: "POST",
          dataType: "text",
          data: JSON.stringify(INSERT_JSON),
          success: (result) => {
            if (result === "true") {
              $("#table").bootstrapTable("refresh", {});
            } else {
              alert("增加操作未成功");
            }
          },
        });
      }
    }

  });

  $("#btn_delete").click(function () {
    var getSelectRows = $("#table").bootstrapTable("getSelections", (books) => { return books });
    if (getSelectRows.length > 0) {
      var s = "";
      $.each(getSelectRows, (i, book) => { s = s + book.Bid + ',' });
      s = s.substring(0, s.length - 1);
      $.post(URL + 'DELETE', { Bid: s }, (result) => {
          if (result === "true") {
            $("#table").bootstrapTable("refresh",
              function () {});
          }
      });
    } else {
      alert("未选择行");
    }
  });

  $('#btn_query').click(function () {
    $("#table").bootstrapTable("refresh", {});
  });

  function InitTable() {
    $('#table').bootstrapTable({
      url: URL,
      toolbar: '#toolbar',
      clickToSelect: true,
      striped: false,
      sidePagination: 'client',
      pagination: true,
      pageNumber: 1,
      pageSize: 10,
      pageList: [10, 25, 50, 100],
      cache: false,
      sortable: true,
      sortOrder: "asc",
      search: false,
      showColumns: true,
      showRefresh: true,
      uniqueId: "Bid",
      idField: 'Bid',
      columns: [{
          checkbox: true,
        },
        {
          field: 'Bid',
          title: '书号',
          sortable: true,
        },
        {
          field: 'Bname',
          title: '书名'
        },
        {
          field: 'Bnumber',
          title: '图书数量',
          sortable: true,
        },],
    });
  }
});